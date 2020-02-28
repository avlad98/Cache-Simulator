import java.util.ArrayList;

/**
 *
 * @author Vlad Andrei-Alexandru
 */
public class LRUCache implements Cache{
    private ArrayList<Subscriptie> cache = new ArrayList();
    private int size = 0;

    /**
     *
     */
    public LRUCache(){
        
    }

    /**
     *
     * @param size
     */
    public LRUCache(int size){
        this.size = size;
    }

    /**
     *
     * @param object
     */
    @Override
    public void add(Subscriptie object) {
        if(this.contains(object.getName())){
            //Update the position of the element in the list
            int index = 0;
            for(int i = 0; i < cache.size(); i++){
                if(cache.get(i).getName().equals(object.getName())){
                        index = i;
                }
            }
            cache.remove(index);
        }else if(cache.size() == this.size) {
            //Remove the elements from the cache based on its rule
            cache.remove(0);
        }

        cache.add(object);
    }

    /**
     *
     */
    @Override
    public void remove(){
        
    }

    /**
     *
     * @param name
     * @return
     */
    @Override
    //Check if an object exists in the cache
    public boolean contains(String name) {
        for(int i = 0; i < cache.size(); i++){
            if(cache.get(i).getName().equals(name)){
                return true;
            }
        }
        
        return false;
    }

    /**
     *
     * @param name
     */
    @Override
    //Remove a specific object from the cache based on its name
    public void remove(String name) {
        int index = 0;
        for(int i = 0; i < cache.size(); i++){
            if(cache.get(i).getName().equals(name)){
                index = i;
            }
        }
        cache.remove(index);
    }

    /**
     *
     * @param objName
     * @return
     */
    @Override
    //Return the reference of a specific object from the cache
    public Subscriptie get(String objName) {
        for(int i = 0; i < cache.size(); i++){
            if(cache.get(i).getName().equals(objName)){
                return cache.get(i);
            }
        }
        
        return null;
    }

}
