package control;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.annotation.PostConstruct;


@ManagedBean(name = "Pag_Encarte")
@ViewScoped
@RequestScoped

public class ProdutoBennView {

	
	 private List<String> images;
     
	 @PostConstruct
	    public void init() {
	        images = new ArrayList<String>();
	        for (int i = 1; i <= 12; i++) {
	            images.add("images" + i + ".png");
	           
	           
	        }
	    }
	 
	    public List<String> getImages() {
	        return images;
	    }
	
}
