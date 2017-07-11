import com.makemytrip.vmconv.ViewModel;
import com.makemytrip.vmconv.utils.ViewModelConverter;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by karthik on 12/07/17.
 */
public class BasicConverterTests {

    @Test
    public void basicBagModelConversions() {
        Map<String, Object> simpleBag = new HashMap<String, Object>() {{
            put("test", "test1");
            put("hello", "world");
            put("hello1", 10);
        }};

        ViewModelConverter converter = new ViewModelConverter();
        ViewModel viewModel = converter.convert(simpleBag);

        System.out.println(viewModel.toJson());
        Assert.assertEquals(viewModel.toJson(), "{\"view\":\"AGGREGATE_VIEW\",\"data\":{\"test\":\"test1\",\"hello1\":10,\"hello\":\"world\"},\"events\":{}}");
    }

    @Test
    public void basicListModelConversions() {
        Map<String, Object> complexBagContainingList = new HashMap<String, Object>() {{
            put("test", "test1");
            put("hello", "world");
            put("hello1", 10);
            put("innerList", new ArrayList<Map<String, Object>>() {{
                add(new HashMap<String, Object>() {{
                    put("innerIndex", 0);
                }});
                add(new HashMap<String, Object>() {{
                    put("innerIndex", 1);
                }});
                add(new HashMap<String, Object>() {{
                    put("innerIndex", 2);
                }});
            }});
        }};

        ViewModelConverter converter = new ViewModelConverter();
        ViewModel viewModel = converter.convert(complexBagContainingList);

        System.out.println(viewModel.toJson());
    }

    @Test
    public void bagModelContainingBagConversions() {
        Map<String, Object> complexBagContainingBag = new HashMap<String, Object>() {{
            put("test", "test1");
            put("hello", "world");
            put("hello1", 10);
            put("innerBag", new HashMap<String, Object>() {{
                put("innerItem", "hello");
                put("innerItem", "world");
            }});
        }};

        ViewModelConverter converter = new ViewModelConverter();
        ViewModel viewModel = converter.convert(complexBagContainingBag);

        System.out.println(viewModel.toJson());
    }

}
