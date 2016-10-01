
package com.ibm.mobileappbuilder.employeesdirectory20150916145522.ds;
import java.net.URL;
import com.ibm.mobileappbuilder.employeesdirectory20150916145522.R;
import ibmmobileappbuilder.ds.RestService;
import ibmmobileappbuilder.util.StringUtils;

/**
 * "ProductsDSService" REST Service implementation
 */
public class ProductsDSService extends RestService<ProductsDSServiceRest>{

    public static ProductsDSService getInstance(){
          return new ProductsDSService();
    }

    private ProductsDSService() {
        super(ProductsDSServiceRest.class);

    }

    @Override
    public String getServerUrl() {
        return "https://ibm-pods.buildup.io";
    }

    @Override
    protected String getApiKey() {
        return "eJkhePau";
    }

    @Override
    public URL getImageUrl(String path){
        return StringUtils.parseUrl("https://ibm-pods.buildup.io/app/57ef4e779d17e00300d4c923",
                path,
                "apikey=eJkhePau");
    }

}

