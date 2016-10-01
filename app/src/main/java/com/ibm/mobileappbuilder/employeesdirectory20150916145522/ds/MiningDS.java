
package com.ibm.mobileappbuilder.employeesdirectory20150916145522.ds;

import ibmmobileappbuilder.ds.Count;
import ibmmobileappbuilder.ds.Datasource;
import ibmmobileappbuilder.ds.Distinct;
import ibmmobileappbuilder.ds.Pagination;
import ibmmobileappbuilder.ds.SearchOptions;
import ibmmobileappbuilder.ds.filter.Filter;
import ibmmobileappbuilder.util.FilterUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * "MiningDS" static data source (9dd5c734-6660-495d-a7f2-ab992731aa47)
 */
public class MiningDS implements Datasource<MiningDSSchemaItem>, Count,
            Pagination<MiningDSSchemaItem>, Distinct {

    private static final int PAGE_SIZE = 20;

    private SearchOptions searchOptions;

    public static MiningDS getInstance(SearchOptions searchOptions){
        return new MiningDS(searchOptions);
    }

    private MiningDS(SearchOptions searchOptions){
        this.searchOptions = searchOptions;
    }

    @Override
    public void getItems(Listener<List<MiningDSSchemaItem>> listener) {
        listener.onSuccess(MiningDSItems.ITEMS);
    }

    @Override
    public int getPageSize(){
        return PAGE_SIZE;
    }

    @Override
    public void getItem(String id, Listener<MiningDSSchemaItem> listener) {
        final int pos = Integer.parseInt(id);
        if(MiningDSItems.ITEMS.size() <= pos){
        	listener.onSuccess(new MiningDSSchemaItem());
        }
        else {
	        MiningDSSchemaItem dc = MiningDSItems.ITEMS.get(pos);
	        if( dc != null)
	            listener.onSuccess(dc);
	        else
	            listener.onFailure(new IllegalArgumentException("MiningDSSchemaItem not found: " + pos));
	    }
    }

    @Override public int getCount(){
        return MiningDSItems.ITEMS.size();
    }

    @Override
    public void getItems(int pagenum, Listener<List<MiningDSSchemaItem>> listener) {
        int first = pagenum * PAGE_SIZE;
        int last = first + PAGE_SIZE;
        ArrayList<MiningDSSchemaItem> result = new ArrayList<MiningDSSchemaItem>();
        List<MiningDSSchemaItem> filteredList = applySearchOptions(MiningDSItems.ITEMS);
        if(first < filteredList.size())
            for (int i = first; (i < last) && (i < filteredList.size()); i++)
                result.add(filteredList.get(i));

        listener.onSuccess(result);
    }

    @Override
    public void onSearchTextChanged(String s){
        searchOptions.setSearchText(s);
    }

    @Override
    public void addFilter(Filter filter){
        searchOptions.addFilter(filter);
    }

    @Override
    public void clearFilters() {
        searchOptions.setFilters(null);
    }

    private List<MiningDSSchemaItem> applySearchOptions(List<MiningDSSchemaItem> result) {
        List<MiningDSSchemaItem> filteredList = result;

        //Searching options
        String searchText = searchOptions.getSearchText();

        if(searchOptions.getFixedFilters() != null)
            filteredList = applyFilters(filteredList, searchOptions.getFixedFilters());

        if(searchOptions.getFilters() != null)
            filteredList = applyFilters(filteredList, searchOptions.getFilters());

        if (searchText != null && !"".equals(searchText))
            filteredList = applySearch(filteredList, searchText);

        //Sorting options
        Comparator comparator = searchOptions.getSortComparator();
        if (comparator != null) {
            if (searchOptions.isSortAscending()) {
                Collections.sort(filteredList, comparator);
            } else {
                Collections.sort(filteredList, Collections.reverseOrder(comparator));
            }
        }

        return filteredList;
    }

    private List<MiningDSSchemaItem> applySearch(List<MiningDSSchemaItem> items, String searchText) {
        List<MiningDSSchemaItem> filteredList = new ArrayList<>();

        for (MiningDSSchemaItem item : items) {
                        
            if (FilterUtils.searchInString(item.id, searchText))
            {
                filteredList.add(item);
            }
        }

        return filteredList;

    }

    private List<MiningDSSchemaItem> applyFilters(List<MiningDSSchemaItem> items, List<Filter> filters) {
        List<MiningDSSchemaItem> filteredList = new ArrayList<>();

        for (MiningDSSchemaItem item : items) {
            if (
                FilterUtils.applyFilters("id", item.id, filters)
                ){

                filteredList.add(item);
            }
        }

        return filteredList;
    }

    // Distinct interface

    @Override
    public void getUniqueValuesFor(String columnName, Listener<List<String>> listener) {
        List<MiningDSSchemaItem> filteredList = applySearchOptions(MiningDSItems.ITEMS);
        listener.onSuccess(mapItems(filteredList, columnName));
    }

    private List<String> mapItems(List<MiningDSSchemaItem> items, String columnName){
        // return only unique values
        ArrayList<String> res = new ArrayList();
        for (MiningDSSchemaItem item: items){
            String mapped = mapItem(item, columnName);
            if(mapped != null && !res.contains(mapped))
                res.add(mapped);
        }

        return res;
    }

    private String mapItem(MiningDSSchemaItem item, String columnName){
        // get fields
        switch (columnName){
                        
            case "id":
                return item.id;
            default:
               return null;
        }
    }
}


