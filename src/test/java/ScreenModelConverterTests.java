import com.makemytrip.vmconv.ScreenModel;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * ScreenModel converter tests.
 */
public class ScreenModelConverterTests {

    @Test
    public void basicScreenModelTests() {
        String screenName = "complexBag";
        ScreenModel screenModel = new ScreenModel(screenName, new ScreenModelTestPojo(), "container");

        String expected = "{\"screen\":\"complexBag\",\"screenModel\":{\"container\":{\"view\":\"AGGREGATE_VIEW\",\"data\":{\"innerBag\":{\"view\":\"AGGREGATE_VIEW\",\"data\":{\"innerItem1\":\"world1\",\"innerItem\":\"hello\"},\"events\":{}},\"hello1\":11.0,\"hello2\":\"test1\",\"hello\":\"world\"},\"events\":{}}}}";
        Assert.assertEquals(expected,
                screenModel.toJson());


        final Map<String, Object> complexBagContainingBag = new HashMap<String, Object>() {{
            put("hello2", "test1");
            put("hello", "world");
            put("hello1", 11.0);
            put("innerBag", new HashMap<String, Object>() {{
                put("innerItem", "hello");
                put("innerItem1", "world1");
            }});
        }};

        screenModel = new ScreenModel(screenName, complexBagContainingBag, "container");
        Assert.assertEquals(expected, screenModel.toJson());

        Map<String, Map<String, Object>> screenMap = new HashMap<String, Map<String, Object>>() {{
             put("container", complexBagContainingBag);
        }};
        screenModel = new ScreenModel(screenName, screenMap);
        Assert.assertEquals(expected,
                screenModel.toJson());
    }
}
