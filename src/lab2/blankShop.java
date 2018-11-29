package lab2;

public class blankShop {
    public blankShop(double countTree){
        this.countTree=countTree;
    }

    public double countTree;

    public double board(){ //доска
        return 1;
    } // Доска

    public double leg(){ //ножка
        return 0.5;
    } // Ножка

    public double chipboard(){ //ДСП плита
        return 0.3;
    } // ДСП плита

    public double dowel(){ //дюбель
        return 0.05;
    } // Дюбель

    public  double replenishment(double countTreeRep){// Добавление дерева
        this.countTree+=countTreeRep;
        return this.countTree;
    }

    public boolean check(double count){
        if(count>countTree) {return false;}
        else {return true;}
    }
}
