package lessons;

import java.io.File;
import java.io.IOException;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class OpenExcel {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		File src = new File("./DataFiles/test-data.xls");
		try{
			Workbook wb = Workbook.getWorkbook(src);
			Sheet sh1 = wb.getSheet(0);
			Cell c1 = sh1.getCell(0,0);
			String data1 = c1.getContents();
			System.out.println(data1);
		}catch(IOException | BiffException e){
			e.printStackTrace();
		}
	}
}
