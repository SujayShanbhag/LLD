import java.util.HashMap;
import java.util.LinkedHashMap;

public class Board {
    public int size;
    public HashMap<Integer,SpecialEntity> specialEntities;

    Board(int size){
        this.size=size;
        specialEntities = new HashMap<>();
        specialEntities.put(28,new Snake(28,12));
        specialEntities.put(78,new Snake(78,34));
        specialEntities.put(69,new Snake(69,6));
        specialEntities.put(84,new Snake(84,65));

        specialEntities.put(24,new Ladder(24, 56));
        specialEntities.put(43,new Ladder(43, 83));
        specialEntities.put(3,new Ladder(3, 31));
        specialEntities.put(72,new Ladder(72, 91));
    }

    public boolean hasSpecialEntity(int cell) {
        return specialEntities.containsKey(cell);
    }

    public int getEndPosition(int cell) {
        if(hasSpecialEntity(cell))
            return specialEntities.get(cell).getEndPosition();
        return cell;
    }

    public void printBoard()
    {
        int totalCells = size*size;
        for(int i=totalCells; i > 0; i--)
        {
            System.out.print(" | " + i + " ");

            if(hasSpecialEntity(i))
                System.out.print("to_"+specialEntities.get(i).getEndPosition());

            System.out.print(" |");
            if(totalCells % 10 == 0)
                System.out.println();
        }
    }

}
