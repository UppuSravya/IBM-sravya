
package com.ibm.mobileappbuilder.employeesdirectory20150916145522.ui;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.ibm.mobileappbuilder.employeesdirectory20150916145522.R;
import ibmmobileappbuilder.behaviors.ShareBehavior;
import ibmmobileappbuilder.ds.restds.AppNowDatasource;
import ibmmobileappbuilder.util.image.ImageLoader;
import ibmmobileappbuilder.util.image.PicassoImageLoader;
import ibmmobileappbuilder.util.StringUtils;
import java.net.URL;
import static ibmmobileappbuilder.util.image.ImageLoaderRequest.Builder.imageLoaderRequest;
import ibmmobileappbuilder.ds.Datasource;
import ibmmobileappbuilder.ds.SearchOptions;
import ibmmobileappbuilder.ds.filter.Filter;
import java.util.Arrays;
import com.ibm.mobileappbuilder.employeesdirectory20150916145522.ds.ProductsDSItem;
import com.ibm.mobileappbuilder.employeesdirectory20150916145522.ds.ProductsDS;

public class AnalyticsDetailFragment extends ibmmobileappbuilder.ui.DetailFragment<ProductsDSItem> implements ShareBehavior.ShareListener  {

    private Datasource<ProductsDSItem> datasource;
    public static AnalyticsDetailFragment newInstance(Bundle args){
        AnalyticsDetailFragment fr = new AnalyticsDetailFragment();
        fr.setArguments(args);

        return fr;
    }

    public AnalyticsDetailFragment(){
        super();
    }

    @Override
    public Datasource<ProductsDSItem> getDatasource() {
      if (datasource != null) {
        return datasource;
      }
       datasource = ProductsDS.getInstance(new SearchOptions());
        return datasource;
    }

    @Override
    public void onCreate(Bundle state) {
        super.onCreate(state);
        addBehavior(new ShareBehavior(getActivity(), this));

    }

    // Bindings

    @Override
    protected int getLayout() {
        return R.layout.analyticsdetail_detail;
    }

    @Override
    @SuppressLint("WrongViewCast")
    public void bindView(final ProductsDSItem item, View view) {
        if (item.text1 != null){
            
            TextView view0 = (TextView) view.findViewById(R.id.view0);
            view0.setText(item.text1);
            
        }
        if (item.text2 != null){
            
            TextView view1 = (TextView) view.findViewById(R.id.view1);
            view1.setText(item.text2);
            
        }
        
        ImageView view2 = (ImageView) view.findViewById(R.id.view2);
        URL view2Media = ((AppNowDatasource) getDatasource()).getImageUrl(item.picture);
        if(view2Media != null){
          ImageLoader imageLoader = new PicassoImageLoader(view2.getContext());
          imageLoader.load(imageLoaderRequest()
                                   .withPath(view2Media.toExternalForm())
                                   .withTargetView(view2)
                                   .fit()
                                   .build()
                    );
        	
        } else {
          view2.setImageDrawable(null);
        }
        if (item.text3 != null){
            
            TextView view3 = (TextView) view.findViewById(R.id.view3);
            view3.setText(item.text3);
            
        }
    }

    @Override
    protected void onShow(ProductsDSItem item) {
        // set the title for this fragment
        getActivity().setTitle(null);
    }
    @Override
    public void onShare() {
        ProductsDSItem item = getItem();

        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.setType("text/plain");

        intent.putExtra(Intent.EXTRA_TEXT, (item.text1 != null ? item.text1 : "" ) + "\n" +
                    (item.text2 != null ? item.text2 : "" ) + "\n" +
                    (item.text3 != null ? item.text3 : "" ));
        startActivityForResult(Intent.createChooser(intent, getString(R.string.share)), 1);
    }
}

