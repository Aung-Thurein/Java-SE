package com.jdc.demo.constants;

public class StatusChecker {

	public static void check(int status) {
		switch (status) {
		case TransactionStatus.PENDING:
			System.out.println("Pending Transaction");
			break;
		case TransactionStatus.APPROVED:
			System.out.println("Approved Transaction");
			break;
		case TransactionStatus.CANCELED:
			System.out.println("Canceled Transaction");
			break;
		default:
			System.out.println("Invaild Transaction");
			break;
		}
		System.out.println(status);

	}

	public static void checkEnum(TransactionState status) {
		switch (status) {
		case APPLIED:
			System.out.println("Applied Transcation");
			break;
		case APPROVED:
			System.out.println("Approved Transaction");
			break;
		case CANCELED:
			System.out.println("Canceled Transcation");
			break;

		}
		System.out.println(status);

	}

	public static void checkEnumwithDays(days day) {
		switch(day) {
		case MON:
		System.out.println("This is Monday");
		break;
		case TUE:
		System.out.println("This is Tueday");
		break;
		case WED:
		System.out.println("This Wednesday");
		break;
		case THU:
		System.out.println("This is Tuesday");
		break;
		case FRI:
		System.out.println("This is Friday");
		break;
		case SAT:
		System.out.println("This is Saturday");
		break;
		case SUN:
		System.out.println("This is Sunday");
		break;
			
			
		}
		
	}

}
