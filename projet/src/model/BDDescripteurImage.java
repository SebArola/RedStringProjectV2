package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BDDescripteurImage {
	//private List<DescripteurImage> listeDescripteurImage = new ArrayList<>();
	private HashMap<String, DescripteurImage> listeDescripteurImage = new HashMap();
	private BDDescripteurImage(){
		listeDescripteurImage.put("imageRVB/testDomineRouge1.jpg", new DescripteurImage("imageRVB/testDomineRouge1.jpg", 47, 30, 23));
		listeDescripteurImage.put("imageRVB/testDomineRouge2.jpg", new DescripteurImage("imageRVB/testDomineRouge2.jpg", 35, 31, 34));
		listeDescripteurImage.put("imageRVB/testDomineVert1.jpg", new DescripteurImage("imageRVB/testDomineVert1.jpg", 12, 56, 32));
		listeDescripteurImage.put("imageRVB/testDomineVert2.jpg", new DescripteurImage("imageRVB/testDomineVert2.jpg", 17, 58, 25));
	}
	private static class BDDescripteurImageHolder{
		private final static BDDescripteurImage instance = new BDDescripteurImage();
	}
	
	public static BDDescripteurImage getInstance(){
		return BDDescripteurImageHolder.instance;
	}
	
	public HashMap<String, DescripteurImage> getAllDescripteursImage(){
		return this.listeDescripteurImage;
	}
	
}
