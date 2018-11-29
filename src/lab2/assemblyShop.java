package lab2;

public class assemblyShop {
    blankShop blank;

//    int countChipboard;
//    int countLeg;
//    int countBoard;
//    int countDowel;
//
//    public double kitchenTree(){
//        return 10*blank.chipboard()+12*blank.leg()+24*blank.dowel()+6*blank.board();
//    }
//    public int kitchenPrice(){
//        return 40000;
//    }
//
//    public double hightstandTree(){
//        return 2*blank.board()+2*blank.chipboard()+12*blank.dowel();
//    }
//    public int highstandPrice(){
//        return 3000;
//    }
//
//    public double cupboardTree(){
//        return 4*blank.board()+blank.chipboard()+8*blank.dowel();
//    }
//    public int cupboardPrice(){
//        return 7000;
//    }
//
//    public double stoolGoodTree(){
//        return blank.board()+4*blank.leg()+12*blank.dowel();
//    }
//    public int stoolGoodPrice(){
//        return 3000;
//    }

    // Порядок в массиве: ДСП, доска, ножка, дюбель, цена

    public int[] countDetailKitchen(){
        int[] count={10,6,12,24,40000};
        return count;
    }

    public int[] countDetailHightstand(){
        int[] count={2,2,0,12,3000};
        return count;
    }

    public int[] countDetailCupboard(){
        int[] count={1,4,0,8,7000};
        return count;
    }

    public int[] countDetailStoolGood(){
        int[] count={0,1,4,4,1500};
        return count;
    }

    public int[] countDetailStoolBad(){
        int[] count={0,1,4,0,1000};
        return count;
    }

    public boolean check(int price, int budget){
        if(price>budget){return  false;}
        else{return true;}
    }

    public  void price(){
        System.out.println("");
        System.out.println("Прайс:");
        System.out.println("  Кухня (фикс. размер)  -  40000");
        System.out.println("  Тумба                 -   3000");
        System.out.println("  Шкаф                  -   7000");
        System.out.println("  Табурет (хороший)     -   1500");
        System.out.println("  Табурет (плохой)      -   1000");
        System.out.println("");
    }
}
