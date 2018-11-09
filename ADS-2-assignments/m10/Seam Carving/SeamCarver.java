import java.awt.Color;
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

	public SeamCarver() {

	}
	public SeamCarver(Picture picture) {
		this.pic = picture;
		this.width = picture.width();
		this.height = picture.height();
		energy = new double[height][width];
		if (pic == null) {
			// throw new Exception("picture is null");
			throw new IllegalArgumentException("picture is null");
		}
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				energy[i][j] = energy(j, i);
			}

		}

	}
	// current picture
	public Picture picture() {
		return pic;
	}
	// width of current picture
	public int width() {
		return width;
	}

	// height of current picture
	public int height() {
		return height;
	}

	// energy of pixel at column x and row y
	public double energy(int x, int y) {
		double resx = 0.0;
		double resy = 0.0;
		Color right;
		Color left;
		Color up;
		Color down;
		if (x < 0 || x > width || y < 0 || y >= height) {
			throw new IllegalArgumentException("picture is null");
		}
		if (x == 0 || y == 0 || x == width - 1 || y == height - 1) {
			return 1000;

		} else {
			right = pic.get(x - 1, y);
			left = pic.get(x + 1, y);
			up = pic.get(x, y - 1);
			down = pic.get(x, y + 1);
			resx = Math.pow((right.getRed() - left.getRed()), 2) + Math.pow((right.getGreen() - left.getGreen()), 2) + Math.pow((right.getBlue() - left.getBlue()), 2);
			resy = Math.pow((up.getRed() - down.getRed()), 2) + Math.pow((up.getGreen() - down.getGreen()), 2) + Math.pow((up.getBlue() - down.getBlue()), 2);
			return Math.sqrt(resx + resy);
		}

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