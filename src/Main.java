import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Vlad Andrei-Alexandru
 */
public class Main {

    /**
     *
     * @param args
     * @throws IOException
     */
    public static void main(String args[]) throws IOException {
        //Open input file 
        File file = new File(args[0]); 
        Scanner input = new Scanner(file); 
        
        //Open output file
        File outfile = new File(args[1]); 
        BufferedWriter output;
        output = new BufferedWriter(new FileWriter(args[1]));
        
        //Parse input file
        String cacheType = input.next();
        int cacheSize = input.nextInt();
        int nOperations = input.nextInt();
        //Ignore the rest of the line
        String line = input.nextLine();
        
        //Initialize the cache
        Cache cache = initCache(cacheType, cacheSize);
        
        //Parse commands
        String[] parts;
        for(int i = 0; i < nOperations; i++){
            line = input.nextLine();
            parts = line.split(" ");
            String objName = parts[1];

            switch (parts[0]){
                case "ADD":
                    //Creating the object
                    int basic = Integer.parseInt(parts[2]);
                    int premium = 0;
                    if(parts.length == 4){premium = Integer.parseInt(parts[3]);}
                    Subscriptie object = Subscriptie.createSubscriptie(objName, basic, premium);

                    ADD(object, cache);
                    break;
                case "GET":
                    GET(output, cache, objName);
                    break;
                default:
                    System.out.println("Error parsing command");
                    break;
            }
        }
        
        //Close output file
        output.close();
    }

    private static Cache initCache(String cacheType, int cacheSize) {

        //Create the cache based on its type from the input file
        Cache cache = null;
        switch(cacheType){
            case "LRU":
                cache = new LRUCache(cacheSize);
                break;
            case "FIFO":
                cache = new FIFOCache(cacheSize);
                break;
            case "LFU":
                cache = new LFUCache(cacheSize);
                break;
            default:
                System.out.println("Error initializing Cache!");
                break;
        }
        
        return cache;
    }

    private static void ADD(Subscriptie object, Cache cache) {
        //Implement the ADD function as described in the document
        if(Memory.contains(object.getName())){
            Memory.overwrite(object);
            if(cache.contains(object.getName())){
                cache.remove(object.getName());
            }
        }else{
            Memory.add(object);
        }

    }

    private static void GET(BufferedWriter output, Cache cache, String objName) throws IOException {
        //Implement the GET function as described in the document
        if(cache.contains(objName)){
            Subscriptie object = cache.get(objName);
            cache.add(object);
            output.write("0 " + object.getType() + "\n");
            object.plus();  //increment the get request for lfu
            object.use();   //consume basic and premium requests
        }else if(Memory.contains(objName)){
            Subscriptie object = Memory.get(objName);
            output.write("1 " + object.getType() + "\n");
            object.use();
            cache.add(object);
        }else{
            output.write("2\n");
        }

    }
}
