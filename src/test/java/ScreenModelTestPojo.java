/**
 * Created by karthik on 12/07/17.
 */
public class ScreenModelTestPojo {
    /*
        put("test", "hello2");
            put("hello", "world");
            put("hello1", 11);
            put("innerBag", new HashMap<String, Object>() {{
                put("innerItem", "hello");
                put("innerItem", "world1");
            }});
     */

    private String hello2 = "test1";
    private String hello = "world";
    private Integer hello1 = 11;
    private InnerBagPojo innerBag = new InnerBagPojo();

    public String getHello2() {
        return hello2;
    }

    public void setHello2(String hello2) {
        this.hello2 = hello2;
    }

    public String getHello() {
        return hello;
    }

    public void setHello(String hello) {
        this.hello = hello;
    }

    public Integer getHello1() {
        return hello1;
    }

    public void setHello1(Integer hello1) {
        this.hello1 = hello1;
    }

    public InnerBagPojo getInnerBagPojo() {
        return innerBag;
    }

    public void setInnerBagPojo(InnerBagPojo innerBagPojo) {
        this.innerBag = innerBagPojo;
    }

    private class InnerBagPojo {

        private String innerItem = "hello";
        private String innerItem1 = "world1";

        public String getInnerItem() {
            return innerItem;
        }

        public void setInnerItem(String innerItem) {
            this.innerItem = innerItem;
        }

        public String getInnerItem1() {
            return innerItem1;
        }

        public void setInnerItem1(String innerItem1) {
            this.innerItem1 = innerItem1;
        }
    }
}
