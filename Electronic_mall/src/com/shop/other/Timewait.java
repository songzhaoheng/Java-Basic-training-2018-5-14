package com.shop.other;
/***等待时间***/

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

public class Timewait {
	public void wait500() {
		try {
			Thread.sleep(500); //等待1秒
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
	}
	
	public void wait1000() {
		try {
			Thread.sleep(1000); //等待1秒
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
	}
	
	public void wait1500() {
		try {
			Thread.sleep(1500); //等待1秒
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
	}
	
	public void wait2000() {
		try {
			Thread.sleep(2000); //等待1秒
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
	}

}
