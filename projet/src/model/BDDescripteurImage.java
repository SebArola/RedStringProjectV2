package model;

import java.util.ArrayList;
import java.util.List;

public class BDDescripteurImage {
	private List<DescripteurImage> listeDescripteurImage = new ArrayList<>();
	private BDDescripteurImage(){
		listeDescripteurImage.add(new DescripteurImage("imageRVB/testDomineRouge.jpg", 47, 30, 23));
		listeDescripteurImage.add(new DescripteurImage("imageRVB/testDomineVert.jpg", 12, 56, 32));
		listeDescripteurImage.add(new DescripteurImage("imageRVB/testDomineBleu.jpg", 17, 25, 58));
	}
	private static class BDDescripteurImageHolder{
		private final static BDDescripteurImage instance = new BDDescripteurImage();
	}
	
	public static BDDescripteurImage getInstance(){
		return BDDescripteurImageHolder.instance;
	}
	
	public List<DescripteurImage> getAllDescripteursImage(){
		return this.listeDescripteurImage;
	}
	
}
