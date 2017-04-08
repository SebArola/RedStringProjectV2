package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BDDescripteurImage {
	//private List<DescripteurImage> listeDescripteurImage = new ArrayList<>();
	private HashMap<String, DescripteurImage> listeDescripteurImage = new HashMap();
	private BDDescripteurImage(){
		listeDescripteurImage.put("imageRVB/testDomineRouge.jpg", new DescripteurImage("imageRVB/testDomineRouge.jpg", 47, 30, 23));
		listeDescripteurImage.put("imageRVB/testDomineVert.jpg", new DescripteurImage("imageRVB/testDomineVert.jpg", 12, 56, 32));
		listeDescripteurImage.put("imageRVB/testDomineBleu.jpg", new DescripteurImage("imageRVB/testDomineBleu.jpg", 17, 25, 58));
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
