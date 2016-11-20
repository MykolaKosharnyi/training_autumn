package pattern;

public class AdapterApp {
	public static void main(String[] args){
		//1-й метод через наследование
		VectorGraphicsInterface vectorGraphicsInterface = new VectorAdapterFromRaster();
		vectorGraphicsInterface.drawLine();
		vectorGraphicsInterface.drawSquare();
		
		//2-й метод через композицию
		vectorGraphicsInterface = new VectorAdapterFromRaster2();
		vectorGraphicsInterface.drawLine();
		vectorGraphicsInterface.drawSquare();
	}
}
	
	interface VectorGraphicsInterface{
		void drawLine();
		void drawSquare();
	}
	
	class RasterGraphics{
		void drawRasterLine(){
			System.out.println("Рисуем линию");
		}
		
		void drawRasterSquare(){
			System.out.println("Рисуем квадрат");
		}
	}
	
	class VectorAdapterFromRaster extends RasterGraphics implements VectorGraphicsInterface{

		@Override
		public void drawLine() {
			drawRasterLine();			
		}

		@Override
		public void drawSquare() {
			drawRasterSquare();			
		}
		
	}

	class VectorAdapterFromRaster2 implements VectorGraphicsInterface{
		RasterGraphics raster = new RasterGraphics();
		
		@Override
		public void drawLine() {
			raster.drawRasterLine();			
		}

		@Override
		public void drawSquare() {
			raster.drawRasterSquare();
		}
		
	}