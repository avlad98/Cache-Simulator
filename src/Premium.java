
/**
 *
 * @author Vlad Andrei-Alexandru
 */
public class Premium extends Basic{
    private int premium = 0;
    
    /**
     *
     */
    public Premium(){
        
    }
    
    /**
     *
     * @param name
     * @param basic
     * @param premium
     */
    public Premium(String name, int basic, int premium){
        super(name, basic);
        this.premium = premium;
    }
    
    /**
     *
     * @return
     */
    @Override
    public String getType(){
        if(this.premium > 0){
            return "Premium";
        }else{
            return super.getType();
        }
    }
    
    /**
     *
     */
    @Override
    public void use(){
        if(this.premium > 0){
            this.premium--;
        }else{
            super.use();
        }
    }
}
