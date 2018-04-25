package test;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import cn.jxc.util.DateConverter;

public class dateTest {
	@Test
	public void a() {
		String aString = "04/05/1988";
		Date convertFromString = DateConverter.convertFromString(aString);
		System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(convertFromString));
		//
		// String convertStringyyyy = DateConverter.convertStringyyyy(aString);
		// System.out.println(convertStringyyyy);
	}

//	@Test
//	public void b() {
//		int [] c=new int[5];
//		for (int i = 0; i < 1 << 20; i++) {
//		        int c[4] = { 0 }, cmin = 10, cmax = 0;
//		        for (int j = 0; j < 10; j++) c[A(j)]++;
//		        for (int j = 0; j < 4; j++) cmin = cmin < c[j] ? cmin : c[j];
//		        for (int j = 0; j < 4; j++) cmax = cmax > c[j] ? cmax : c[j];
//		        if ((A(1) == 0 && A(4) == 2 ||
//		             A(1) == 1 && A(4) == 3 ||
//		             A(1) == 2 && A(4) == 0 ||
//		             A(1) == 3 && A(4) == 1) &&
//		            (A(2) == 0 && A(2) != A(5) && A(2) != A(1) && A(2) != A(3) ||
//		             A(2) == 1 && A(5) != A(2) && A(5) != A(1) && A(5) != A(3) ||
//		             A(2) == 2 && A(1) != A(2) && A(1) != A(5) && A(1) != A(3) ||
//		             A(2) == 3 && A(3) != A(2) && A(3) != A(5) && A(3) != A(1)) &&
//		            (A(3) == 0 && A(0) == A(4) ||
//		             A(3) == 1 && A(1) == A(6) ||
//		             A(3) == 2 && A(0) == A(8) ||
//		             A(3) == 3 && A(5) == A(9)) &&
//		            (A(4) == 0 && A(7) == 0 ||
//		             A(4) == 1 && A(3) == 1 ||
//		             A(4) == 2 && A(8) == 2 ||
//		             A(4) == 3 && A(6) == 3) &&
//		            (A(5) == 0 && A(1) == A(7) && A(3) == A(7) ||
//		             A(5) == 1 && A(0) == A(7) && A(5) == A(7) ||
//		             A(5) == 2 && A(2) == A(7) && A(9) == A(7) ||
//		             A(5) == 3 && A(4) == A(7) && A(8) == A(7)) &&
//		            (A(6) == 0 && c[2] < c[0] && c[2] < c[1] && c[2] < c[3] ||
//		             A(6) == 1 && c[1] < c[0] && c[1] < c[2] && c[1] < c[3] ||
//		             A(6) == 2 && c[0] < c[1] && c[0] < c[2] && c[0] < c[3] ||
//		             A(6) == 3 && c[3] < c[0] && c[3] < c[1] && c[3] < c[2]) &&
//		            (A(7) == 0 && abs(A(0) - A(6)) != 1 ||
//		             A(7) == 1 && abs(A(0) - A(4)) != 1 ||
//		             A(7) == 2 && abs(A(0) - A(1)) != 1 ||
//		             A(7) == 3 && abs(A(0) - A(9)) != 1) &&
//		            (A(8) == 0 && (A(0) == A(5)) != (A(5) == A(4)) ||
//		             A(8) == 1 && (A(0) == A(5)) != (A(9) == A(4)) ||
//		             A(8) == 2 && (A(0) == A(5)) != (A(1) == A(4)) ||
//		             A(8) == 3 && (A(0) == A(5)) != (A(8) == A(4))) &&
//		            (A(9) == 0 && cmax - cmin == 3 ||
//		             A(9) == 1 && cmax - cmin == 2 ||
//		             A(9) == 2 && cmax - cmin == 4 ||
//		             A(9) == 3 && cmax - cmin == 1))
//		            for (int j = 0; j < 10; j++)
//		                putchar('A' + A(j));
//		    }
//	}
}
