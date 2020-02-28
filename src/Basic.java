
/**
 *
 * @author Vlad Andrei-Alexandru
 */
public class Basic extends Free{
    private int basic = 0;
    
    /**
     *
     */
    public Basic(){
        
    }
    
    /**
     *
     * @param name
     * @param basic
     */
    public Basic(String name, int basic){
        super(name);
        this.basic = basic;
    }
    
    /**
     *
     * @return
     */
    @Override
    public String getType(){
        if(this.basic > 0){
            return "Basic";
        }else{
            return super.getType();
        }
    }

    /**
     *
     */
    @Override
    public void use() {
        if(this.basic > 0){
            this.basic--;
        }
    }

    
    
}
