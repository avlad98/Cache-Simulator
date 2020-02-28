
/**
 *
 * @author Vlad Andrei-Alexandru
 */
public class Free extends Subscriptie{
    
    /**
     *
     */
    public Free(){
        
    }
    
    /**
     *
     * @param name
     */
    public Free(String name){
        super(name);
    }
    
    /**
     *
     * @return
     */
    @Override
    public String getType(){
        return "Free";
    }

    /**
     *
     */
    @Override
    public void use() {
        
    }

    
}
