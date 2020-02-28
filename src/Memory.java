import java.util.ArrayList;

/**
 *
 * @author Vlad Andrei-Alexandru
 */
public class Memory {
    static ArrayList<Subscriptie> memory = new ArrayList();

    //Add the object in the list as new

    /**
     *
     * @param object
     */
    public static void add(Subscriptie object){
        memory.add(object);
    }

    //Overwrite the element in the memory (if it exists)

    /**
     *
     * @param object
     */
    public static void overwrite(Subscriptie object){
        for(int i = 0; i < memory.size(); i++){
            Subscriptie oldObject = memory.get(i);
            if(oldObject.getName().equals(object.getName())){
                memory.remove(i);
                memory.add(i, object);
                break;
            }
        }
    }

    //Check if the memory contains a specific object based on its name

    /**
     *
     * @param name
     * @return
     */
    public static boolean contains(String name) {
        boolean contains = false;

        for(int i = 0; i < memory.size(); i++){
            Subscriptie object = memory.get(i);
            if(object.getName().equals(name)){
                contains = true;
            }
        }
        
        return contains;
    }

    //Return the reference of a specific object from the memory list
    static Subscriptie get(String objName) {
        Subscriptie object = null;
        
       for(int i = 0; i < memory.size(); i++){
            Subscriptie tmp = memory.get(i);
            if(tmp.getName().equals(objName)){
                object = tmp;
                break;
            }
        }
        
        return object;
    }
    
}
