package com.makemytrip.vmconv;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ScrollView Model
 */
public class ListViewModel implements ViewModel {
    private String view = "SCROLL_VIEW";
    private List<BagViewModel> data = new ArrayList<BagViewModel>();
    private Map<String, Object> events = new HashMap<String, Object>();

    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }

    public List<BagViewModel> getData() {
        return data;
    }

    public void setData(List<BagViewModel> data) {
        this.data = data;
    }

    public Map<String, Object> getEvents() {
        return events;
    }

    public void setEvents(Map<String, Object> events) {
        this.events = events;
    }

    public String toJson() {
        return new Gson().toJson(this, ListViewModel.class);
    }
}
