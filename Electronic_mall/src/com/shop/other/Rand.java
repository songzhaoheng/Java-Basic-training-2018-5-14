package com.shop.other;
/***ÁùÎ»Ëæ»úÊý***/

import com.shop.user.*;
import com.shop.admin.*;
import com.shop.index.*;
import com.shop.mysql.*;
import com.shop.other.*;
import java.sql.*;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.math.*;
import static java.lang.System.out;

public class Rand {
	
	public int getRandom(){
		int num = (int)((Math.random()*9+1)*1000);
		return num;
	}

}
