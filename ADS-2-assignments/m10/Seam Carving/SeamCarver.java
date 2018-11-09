
public class SeamCarver {
	// create a seam carver object based on the given picture
	private Picture pic;
	private int width;
	private int height;
	private double[][] energy;
	private double top = 0.0;
	private double bottom = 0.0;
	public double[][] getenergy() {
		return energy;
	}

	public void setenergy(double[][] energy) {
		this.energy = energy;
	}
	public double gettop() {
		return top;
	}

	public void settop(double top) {
		this.top = top;
	}
	public double  getbottom() {
		return bottom;
	}

	public void setbottom(double  bottom) {
		this.bottom = bottom;
	}
	public int getheight() {
		return height;
	}

	public void setheight(int height) {
		this.height = height;
	}

	public Picture getpic() {
		return pic;
	}

	public void setpic(Picture pic) {
		this.pic = pic;
	}
	public int getwidth() {
		return width;
	}

	public void setwidth(int width) {
		this.width = width;
	}
	public SeamCarver() {
		
	}
	public SeamCarver(Picture picture) throws Exception {
		this.pic = picture;
		this.width = picture.width();
		this.height = picture.height();
		energy = new double[height][width];
		if (pic == null) {
			throw new Exception("picture is null");
		}
		for (int i = 0; i < height; i++) {
			for (int j=0; j<width; j++) {
				energy[i][j] = energy(i, j);	
			}

		}

	}
	// current picture
	public Picture picture() {
		return null;
	}
	// width of current picture
	public int width() {
		return 0;
	}

	// height of current picture
	public int height() {
		return 0;
	}

	// energy of pixel at column x and row y
	public double energy(int x, int y) {
		return 0;
	}

	// sequence of indices for horizontal seam
	public int[] findHorizontalSeam() {
		return new int[0];
	}

	// sequence of indices for vertical seam
	public int[] findVerticalSeam() {
		return new int[0];
	}

	// remove horizontal seam from current picture
	public void removeHorizontalSeam(int[] seam) {

	}

	// remove vertical seam from current picture
	public void removeVerticalSeam(int[] seam) {

	}
}