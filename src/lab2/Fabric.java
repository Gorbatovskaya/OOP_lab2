package lab2;

import java.util.Scanner;

public class Fabric {
    private static Scanner in;
    private  static assemblyShop assembly;
    private static blankShop blank;

    public static void main(String[] args){
        in=new Scanner(System.in);

        System.out.println("Введите начальное значение древесины: ");
        int countTree=Integer.parseInt(in.nextLine());
        assembly = new assemblyShop();
        blank = new blankShop(countTree);

        while (true){
            System.out.println("Введите команду:");
            System.out.println("   order для составления заказа");
            System.out.println("   add для добавления древесины");
            System.out.println("   countTree для показа кол-ва дерева");

            String command=in.nextLine();
            switch (command){
                case "order":
                    boolean or=order();

                    if (or==true){
                        System.out.println("Заказ выполнен");
                    }
                    else{
                        System.out.println("Заказ отменен");
                    }

                    break;
                case "add":
                    System.out.println("Введите количество дерева для пополнения: ");
                    double c=Integer.parseInt(in.nextLine());
                    blank.replenishment(c);
                    System.out.println("Сейчас на складе "+blank.countTree+" дерева");
                    break;
                case  "countTree":
                    System.out.println(blank.countTree);
                    break;
                default:
                    System.out.println("Команда не распознана. Повторите ввод");
                    break;
            }
        }
    }

    private static boolean order(){
        int[] order = new  int[6];
        assembly.price();
        System.out.println("Введине количество денег, выделенных для заказа:");
        order[5]=Integer.parseInt(in.nextLine());
        System.out.println("Введите количество кухонь:");
        order[0]=Integer.parseInt(in.nextLine());
        System.out.println("Введите количество тумб:");
        order[1]=Integer.parseInt(in.nextLine());
        System.out.println("Введите количество шкафов:");
        order[2]=Integer.parseInt(in.nextLine());
        System.out.println("Введите количество хороших табуретов:");
        order[3]=Integer.parseInt(in.nextLine());
        System.out.println("Введите количество плохих табуретов:");
        order[4]=Integer.parseInt(in.nextLine());

        int totalPrice=0;
        double totalTree=0;
        int[] furn;
        furn=assembly.countDetailKitchen();
        totalPrice+=order[0]*furn[4];
        totalTree+=order[0]*(blank.chipboard()*furn[0]+blank.board()*furn[1]+blank.leg()*furn[2]+blank.dowel()*furn[3]);
        furn=assembly.countDetailHightstand();
        totalPrice+=order[1]*furn[4];
        totalTree+=order[1]*(blank.chipboard()*furn[0]+blank.board()*furn[1]+blank.leg()*furn[2]+blank.dowel()*furn[3]);
        furn=assembly.countDetailCupboard();
        totalPrice+=order[2]*furn[4];
        totalTree+=order[2]*(blank.chipboard()*furn[0]+blank.board()*furn[1]+blank.leg()*furn[2]+blank.dowel()*furn[3]);
        furn=assembly.countDetailStoolGood();
        totalPrice+=order[3]*furn[4];
        totalTree+=order[3]*(blank.chipboard()*furn[0]+blank.board()*furn[1]+blank.leg()*furn[2]+blank.dowel()*furn[3]);
        furn=assembly.countDetailStoolBad();
        totalPrice+=order[4]*furn[4];
        totalTree+=order[4]*(blank.chipboard()*furn[0]+blank.board()*furn[1]+blank.leg()*furn[2]+blank.dowel()*furn[3]);


//        switch (com){
//            case "true":
//
//                break;
//            case "false":
//                System.out.println("Средства не дополнены");
//                System.out.println("Чек отменен");
//                return false;
//        }
        if(!assembly.check(totalPrice,order[5])){
            System.out.println("Недостаточно средств.");
            System.out.println("Нужно: "+String.valueOf(totalPrice)+ " У вас: " +String.valueOf(order[5]));
            System.out.println("Добавить средств?");
            System.out.println("true/false");
            String com = in.nextLine();
            switch (com) {
                case "true":
                    System.out.println("Средства дополнены");
                    order[5]=totalPrice;
                case "false":
                    System.out.println("Средства не дополнены");
                    System.out.println("Чек отменен");
                    return false;
                default:
                    System.out.println("Неверное значение");
                    break;
            }
        }

        if(!blank.check(totalTree)){
            System.out.println("Недостаточно дерева");
            System.out.println("Чек отменен");
            return false;
        }

        inputOrder(order,totalPrice);
        System.out.println("");
        System.out.println("Выполнить заказ? true/false");

        String com = "";
        com=in.nextLine();

        switch (com){
            case "true":

                break;
            case "false":

                return false;
        }

        blank.replenishment(-1*totalTree);

        return true;
    }

    private static String check(int price, int budget){

        return "true";
    }

    private static void inputOrder(int[] order, int price){
        System.out.println("Получившийся чек:");
        if (order[0]!=0) System.out.println("   Кухня:            "+order[0]+" шт.");
        if (order[1]!=0) System.out.println("   Тумба:            "+order[1]+" шт.");
        if (order[2]!=0) System.out.println("   Шкаф:             "+order[2]+" шт.");
        if (order[3]!=0) System.out.println("   Табурет хороший:  "+order[3]+" шт.");
        if (order[4]!=0) System.out.println("   Табурет плохой:   "+order[4]+" шт.");
        System.out.println("");
        System.out.println("      Цена: "+price+" рублей");
        int rem = order[5]-price;
        System.out.println("      Сдача: "+rem+" рублей");
    }
}
