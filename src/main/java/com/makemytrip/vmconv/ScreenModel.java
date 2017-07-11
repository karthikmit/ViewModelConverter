package com.makemytrip.vmconv;

import com.google.gson.Gson;
import com.makemytrip.vmconv.utils.JSONUtils;
import com.makemytrip.vmconv.utils.ViewModelConverter;

import java.util.HashMap;
import java.util.Map;

/**
 * ScreenModel
 */
public class ScreenModel implements ViewModel {
    private String screen = "";
    private Map<String, ViewModel> screenModel = new HashMap<String, ViewModel>();

    public ScreenModel(String screen, final Object completeScreenObject, final String containerName) {
        this(screen, new HashMap<String, Map<String, Object>>() {{
            put(containerName, JSONUtils.convertObjectToMap(completeScreenObject));
        }});
    }

    private String getJson(Object completeScreenObject) {
        return new Gson().toJson(completeScreenObject);
    }

    public ScreenModel(String screen, final Map<String, Object> completeScreenObject, final String containerName) {
        this(screen, new HashMap<String, Map<String, Object>>() {{
            put(containerName, completeScreenObject);
        }});
    }

    public ScreenModel(String screen, Map<String, Map<String, Object>> screenDataMap) {
        this.screen = screen;

        // Only one Key is expected.
        for(String key : screenDataMap.keySet()) {
            this.screenModel.put(key, ViewModelConverter.getInstance().convert(screenDataMap.get(key)));
        }
    }

    public String toJson() {
        return new Gson().toJson(this, ScreenModel.class);
    }
}
