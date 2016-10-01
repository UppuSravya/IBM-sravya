

package com.ibm.mobileappbuilder.employeesdirectory20150916145522.ui;

import android.os.Bundle;

import com.ibm.mobileappbuilder.employeesdirectory20150916145522.R;

import java.util.ArrayList;
import java.util.List;

import ibmmobileappbuilder.MenuItem;

import ibmmobileappbuilder.actions.StartActivityAction;
import ibmmobileappbuilder.util.Constants;

/**
 * MenuFragment menu fragment.
 */
public class MenuFragment extends ibmmobileappbuilder.ui.MenuFragment {

    /**
     * Default constructor
     */
    public MenuFragment(){
        super();
    }

    // Factory method
    public static MenuFragment newInstance(Bundle args) {
        MenuFragment fragment = new MenuFragment();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
      public void onCreate(Bundle savedInstanceState) {
          super.onCreate(savedInstanceState);
                }

    // Menu Fragment interface
    @Override
    public List<MenuItem> getMenuItems() {
        ArrayList<MenuItem> items = new ArrayList<MenuItem>();
        items.add(new MenuItem()
            .setLabel("Project")
            .setIcon(R.drawable.png_images727)
            .setAction(new StartActivityAction(EmployeesActivity.class, Constants.DETAIL))
        );
        items.add(new MenuItem()
            .setLabel("New Project")
            .setIcon(R.drawable.png_download4)
            .setAction(new StartActivityAction(StatusActivity.class, Constants.DETAIL))
        );
        items.add(new MenuItem()
            .setLabel("Blast")
            .setIcon(R.drawable.jpg_download1461)
            .setAction(new StartActivityAction(NewsActivity.class, Constants.DETAIL))
        );
        items.add(new MenuItem()
            .setLabel("Drill")
            .setIcon(R.drawable.jpg_k11537096774)
            .setAction(new StartActivityAction(ContactInformationActivity.class, Constants.DETAIL))
        );
        items.add(new MenuItem()
            .setLabel("fleet")
            .setIcon(R.drawable.jpg_240f61422039dbra193sr0dn9yyoge6woaxevetuua4x621)
            .setAction(new StartActivityAction(FleetActivity.class, Constants.DETAIL))
        );
        items.add(new MenuItem()
            .setLabel("Analytics")
            .setIcon(R.drawable.png_download1976)
            .setAction(new StartActivityAction(AnalyticsActivity.class, Constants.DETAIL))
        );
        return items;
    }

    @Override
    public int getLayout() {
        return R.layout.fragment_grid;
    }

    @Override
    public int getItemLayout() {
        return R.layout.menu_item;
    }
}

