package java_project.HWJ;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;


   

public class HW4 
{   
    
    public static void main(String[] args) {
        int[][] map = createMap();

        int lockСells = 10;

        fillMap(map, lockСells);

        Point startPoint = getStartPoint(map);
        Point endPoint = getEndPoint(map, startPoint);

        injectPoint(startPoint, map, 1);
        injectPoint(endPoint, map, -5);
    
        printMap(map);

        Queue<Point> pointQueue = new LinkedList<Point>();

        pointQueue.add(startPoint);

        move(map, pointQueue,10, 10); 

        printMap(map);
    }

    public static void printMap(int[][] map) 
    {  
        for (int[] ints : map) {
            System.out.println(Arrays.toString(ints)+"\t");
        }
    }

    private static int[][] createMap()
    {
        return new int[10][10];
    }

    public static int[][] fillMap(int[][] map,int lockСells) 
    {   
        for (int i = 0; i < map.length; i++) 
        {
            for (int j = 0; j < map[i].length; j++) 
            {
                map[i][j] = 0;
            }
        }
        
        Random random = new Random();

        for (int i = 0; i < lockСells; i++) 
        {   
            int x = random.nextInt(map.length-1);
            int y = random.nextInt(map[0].length-1);

            map[x][y] = -1;

            System.out.println(x+","+y+ "<<<<< СТЕНА"+ i);
        }

        return map;  
    }


    private static Point getStartPoint(int[][] map) 
    {   
        Random random = new Random();

        int x = random.nextInt(map.length);
        int y = random.nextInt(map[0].length);

        Point point = new Point(x,y);

        System.out.println(x + ","+ y + "<<<ТОЧКА");

        int count = 0; 

        while (count <1) 
        {
            if (map[x][y]!= -1) 
            {   
                
                count +=1;
            }
        }

        return point;
    }

    private static Point getEndPoint(int[][] map, Point startPoint) 
    {   
        Random random = new Random();

        int x = random.nextInt(map.length);
        int y = random.nextInt(map[0].length);

        Point point = new Point(x,y);

        int count = 0; 
        while (count <1) 
        {
            if (map[x][y]!= -1) 
            {
                if (!point.equals(startPoint)) 
                {
                    count +=1;    
                }   
            }
        }

        return point;
    }

    public static void injectPoint(Point point, int[][] map, int element) 
    {  
        map[point.x][point.y] = element;
    }

    // проверка нижней V  ячейки, принимаем массив(лабиринт), и точку из которой ходим
    public static void move(int[][] map, Queue pointQueue, int m, int n) 
    {
            boolean f = true;
            while (pointQueue.size() != 0 & f) 
            {
                Point point = (Point) pointQueue.remove();

                int x = point.x;
                int y = point.y;
                
                if (point.x >= (m - 1) | point.x <= 0 | point.y >= (n - 1) | point.y <= 0)
                {
                    System.out.println( x+","+y +"  ход запрещён");    
                    continue;
                }

                if (map[point.x - 1][point.y] == -5) //ПРОВЕРКА 1
                {
                    map[point.x][point.y] = map[point.x][point.y] * (-1);
                    System.out.println(pointQueue.size()+ "!!!КОНГРАТЮЛЭЙШЭНС  - вы пришли" );
                    f = false;
                }
                if (map[point.x - 1][point.y] == 0) 
                {
                    pointQueue.add(new Point(point.x - 1, point.y));
                    map[point.x - 1][point.y] = map[point.x][point.y] + 1;
                    System.out.println(pointQueue.size()+ "<<<очередь-ход" );
                }

                if (map[point.x][point.y - 1] == -5) //ПРОВЕРКА 2
                {   
                    map[point.x][point.y] = map[point.x][point.y] * (-1);
                    System.out.println(pointQueue.size()+ "!!!КОНГРАТЮЛЭЙШЭНС  - вы пришли" ); 
                    f = false;
                }
                if (map[point.x][point.y - 1] == 0) 
                {
                    pointQueue.add(new Point(point.x, point.y - 1));
                    map[point.x][point.y - 1] = map[point.x][point.y] + 1;
                    System.out.println(pointQueue.size()+ "<<<очередь-ход" );
                }

                if (map[point.x + 1][point.y] == -5) //ПРОВЕРКА 3
                {
                    map[point.x][point.y] = map[point.x][point.y]* (-1);
                    System.out.println(pointQueue.size()+ "!!!КОНГРАТЮЛЭЙШЭНС  - вы пришли" ); 
                    f = false;
                }
                if (map[point.x + 1][point.y] == 0) 
                {
                    pointQueue.add(new Point(point.x + 1, point.y));
                    map[point.x + 1][point.y] = map[point.x][point.y] + 1;
                    System.out.println(pointQueue.size()+ "<<<очередь-ход" );
                }


                if (map[point.x][point.y + 1] == -5) //ПРОВЕРКА 4
                {
                    map[point.x][point.y] = map[point.x][point.y] * (-1);
                    System.out.println(pointQueue.size()+ "!!!КОНГРАТЮЛЭЙШЭНС  - вы пришли" ); 
                    f = false;
                }
                if (map[point.x][point.y + 1] == 0)  
                {
                    pointQueue.add(new Point(point.x, point.y + 1));
                    map[point.x][point.y + 1] = map[point.x][point.y] + 1;
                    System.out.println(pointQueue.size()+ "<<<очередь-ход" );
                }
                
            }
    }

}
class Point
   {
        int x;
        int y;
        static int mark;
        public Point(int x, int y)
        {   
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) 
        {
            Point t = (Point) obj;
            return this.x == t.x && this.y == t.y;
        }
    }   

