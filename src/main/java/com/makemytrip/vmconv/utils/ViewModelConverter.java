package com.makemytrip.vmconv.utils;

import com.makemytrip.vmconv.BagViewModel;
import com.makemytrip.vmconv.ListViewModel;
import com.makemytrip.vmconv.ViewModel;

import java.util.List;
import java.util.Map;

/**
 * Converter Utility.
 */
public class ViewModelConverter {

    public ViewModel convert(Map<String, Object> simpleBag) {
        BagViewModel bagViewModel = new BagViewModel();

        for(String key : simpleBag.keySet()) {
            Object value = simpleBag.get(key);

            if(value instanceof Map) {
                bagViewModel.getData().put(key, convert((Map<String, Object>) value));
            } else if(value instanceof List) {
                bagViewModel.getData().put(key, convert((List) value));
            } else {
                bagViewModel.getData().put(key, value);
            }
        }

        return bagViewModel;
    }

    private ViewModel convert(List<Map<String, Object>> value) {
        ListViewModel listViewModel = new ListViewModel();

        for(Map<String, Object> listItem : value) {
            listViewModel.getData().add((BagViewModel) convert(listItem));
        }

        return listViewModel;
    }

    private static ViewModelConverter instance = new ViewModelConverter();

    public static ViewModelConverter getInstance() {
        return instance;
    }

}
