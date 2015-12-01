package com.va.vo;

/**
 * <p>
 * SalesInfo is a value object. The class is a container for calculated amounts
 * and counts used for reporting.
 * </p>
 * 
 * <p>
 * The SalesInfo value object is designed to hold the counts for all
 * registrations and sales for 1 day. However, there is no reason this class
 * cannot be used to hold counts and values for any time range other than 1 day.
 * </p>
 * 
 * <p>
 * This class is not designed for subclassing.
 * </p>
 * 
 * @author unknown
 * @author alan
 * 
 * @version $Id: SalesInfo.java,v 1.1 2006/08/29 18:27:34 alan Exp $
 * 
 */
public class SalesInfo {
	/**
	 * <p>
	 * A String to describe the day the SalesInfo object contains counts for.
	 * Actually, there is no reason to restrict the SalesInfo data to 1 day. It
	 * can be used to keep records on any time range.
	 * </p>
	 */
	public String _day;

	/**
	 * <p>
	 * TODO Should deprecate. This was used when a SalesInfo object was
	 * reporting or only 1 product. Now many products are accounted for in
	 * SalesInfo.
	 * </p>
	 */
	public int product;

	/**
	 * <p>
	 * A String to describe the report type that the SalesInfo object is being
	 * used in.
	 * </p>
	 */
	public String reportType;

	// Begin the total summation results counters
	// ===================================

	/**
	 * <p>
	 * The count of all full registrations.
	 * </p>
	 */
	public int _total;

	/**
	 * <p>
	 * The US Dollar value of all full registrations.
	 * </p>
	 */
	public float _total$;

	/**
	 * <p>
	 * The count of all trial registrations.
	 * </p>
	 */
	public int _ttotal;

	/**
	 * <p>
	 * The US Dollar value of all trial registrations.
	 * </p>
	 */
	public float _ttotal$;

	/**
	 * <p>
	 * The count of all registration conversions.
	 * </p>
	 */
	public int _ctotal;

	/**
	 * <p>
	 * The US Dollar value of all registration conversions.
	 * </p>
	 */
	public float _ctotal$;

	// Begin the individual registration counters
	// ===================================

	/**
	 * <p>
	 * The count of 1 year primary registrations.
	 * </p>
	 */
	public int _n1YearPrimary;

	/**
	 * <p>
	 * The US Dollar value of 1 year primary registrations.
	 * </p>
	 */
	public float _n1YearPrimary$;

	/**
	 * <p>
	 * The count of 3 year primary registrations.
	 * </p>
	 */
	public int _n3YearPrimary;

	/**
	 * <p>
	 * The US Dollar value of 3 year primary registrations.
	 * </p>
	 */
	public float _n3YearPrimary$;

	// 03-01-2006 kohara for pricing changes add 5 year attributes
	/**
	 * <p>
	 * The count of 5 year primary registrations.
	 * </p>
	 */
	public int _n5YearPrimary;

	/**
	 * <p>
	 * The US Dollar value of 5 year primary registrations.
	 * </p>
	 */
	public float _n5YearPrimary$;

	/**
	 * <p>
	 * The count of 1 year family registrations.
	 * </p>
	 */
	public int _n1YearSupp;

	/**
	 * <p>
	 * The US Dollar value of 1 year family registrations.
	 * </p>
	 */
	public float _n1YearSupp$;

	/**
	 * <p>
	 * The count of 3 year family registrations.
	 * </p>
	 */
	public int _n3YearSupp;

	/**
	 * <p>
	 * The US Dollar value of 3 year family registrations.
	 * </p>
	 */
	public float _n3YearSupp$;

	// 03-01-2006 kohara for pricing changes add 5 year attributes
	/**
	 * <p>
	 * The count of 5 year family registrations.
	 * </p>
	 */
	public int _n5YearSupp;

	/**
	 * <p>
	 * The US Dollar value of 5 year family registrations.
	 * </p>
	 */
	public float _n5YearSupp$;

	/**
	 * <p>
	 * The count of sponsored card registrations.
	 * </p>
	 */
	public int _sp;

	/**
	 * <p>
	 * The US Dollar value of sponsored card registrations.
	 * </p>
	 */
	public float _sp$;

	/**
	 * <p>
	 * The count of replacement card registrations.
	 * </p>
	 */
	public int _re;

	/**
	 * <p>
	 * The US Dollar value of replacement card registrations.
	 * </p>
	 */
	public float _re$;

	/**
	 * <p>
	 * The count of family replacement card registrations.
	 * </p>
	 */
	public int _reDep;

	/**
	 * <p>
	 * The US Dollar value of family replacement card registrations.
	 * </p>
	 */
	public float _reDep$;

	/**
	 * <p>
	 * The count of 1 year primary trial registrations.
	 * </p>
	 */
	public int _trial;

	/**
	 * <p>
	 * The US Dollar value of 1 year primary trial registrations.
	 * </p>
	 */
	public float _trial$;

	/**
	 * <p>
	 * The count of 1 year family trial registrations.
	 * </p>
	 */
	public int _trialDep;

	/**
	 * <p>
	 * The US Dollar value of 1 year family trial registrations.
	 * </p>
	 */
	public float _trialDep$;

	/**
	 * <p>
	 * The count of 3 year primary trial registrations.
	 * </p>
	 */
	public int _trial3;

	/**
	 * <p>
	 * The US Dollar value of 3 year primary trial registrations.
	 * </p>
	 */
	public float _trial3$;

	// 03-01-2006 kohara for pricing changes add 5 year attributes
	/**
	 * <p>
	 * The count of 5 year primary trial registrations.
	 * </p>
	 */
	public int _trial5;

	/**
	 * <p>
	 * The US Dollar value of 5 year primary trial registrations.
	 * </p>
	 */
	public float _trial5$;

	/**
	 * <p>
	 * The count of 3 year family trial registrations.
	 * </p>
	 */
	public int _trialDep3;

	/**
	 * <p>
	 * The US Dollar value of 3 year family trial registrations.
	 * </p>
	 */
	public float _trialDep3$;

	// 03-01-2006 kohara for pricing changes add 5 year attributes
	/**
	 * <p>
	 * The count of 5 year family trial registrations.
	 * </p>
	 */
	public int _trialDep5;

	/**
	 * <p>
	 * The US Dollar value of 5 year family trial registrations.
	 * </p>
	 */
	public float _trialDep5$;

	/**
	 * <p>
	 * The count of 1 year primary trial registration conversions.
	 * </p>
	 */
	public int _conv;

	/**
	 * <p>
	 * The US Dollar value of 1 year primary trial registration conversions.
	 * </p>
	 */
	public float _conv$;

	/**
	 * <p>
	 * The count of 1 year family trial registration conversions.
	 * </p>
	 */
	public int _convDep;

	/**
	 * <p>
	 * The US Dollar value of 1 year family trial registration conversions.
	 * </p>
	 */
	public float _convDep$;

	/**
	 * <p>
	 * The count of 3 year primary trial registration conversions.
	 * </p>
	 */
	public int _conv3;

	/**
	 * <p>
	 * The US Dollar value of 3 year primary trial registration conversions.
	 * </p>
	 */
	public float _conv3$;

	// 03-01-2006 kohara for pricing changes add 5 year attributes
	/**
	 * <p>
	 * The count of 5 year primary trial registration conversions.
	 * </p>
	 */
	public int _conv5;

	/**
	 * <p>
	 * The US Dollar value of 5 year primary trial registration conversions.
	 * </p>
	 */
	public float _conv5$;

	/**
	 * <p>
	 * The count of 3 year family trial registration conversions.
	 * </p>
	 */
	public int _convDep3;

	/**
	 * <p>
	 * The US Dollar value of 3 year family trial registration conversions.
	 * </p>
	 */
	public float _convDep3$;

	// 03-01-2006 kohara for pricing changes add 5 year attributes
	/**
	 * <p>
	 * The count of 5 year family trial registration conversions.
	 * </p>
	 */
	public int _convDep5;

	/**
	 * <p>
	 * The US Dollar value of 5 year family trial registration conversions.
	 * </p>
	 */
	public float _convDep5$;

	// 06-15-2006 kohara add companion ticket totals
	/**
	 * <p>
	 * The count of companion tickets sold.
	 * </p>
	 */
	public int _cmpTkt;

	/**
	 * <p>
	 * The US Dollar value of companion tickets sold.
	 * </p>
	 */
	public float _cmpTkt$;

	// -------------------------------------------------------------------------------
	// Public methods.

	/**
	 * <p>
	 * No-argument constructor.
	 * </p>
	 */
	public SalesInfo() {
	}

	public String toString() {
		return "day: " + _day + " _n1YearPrimary:" + _n1YearPrimary + " _n1YearPrimary$:" + _n1YearPrimary$
				+ " _n3YearPrimary:" + _n3YearPrimary + " _n3YearPrimary$:" + _n3YearPrimary$ + " _n5YearPrimary:"
				+ _n5YearPrimary + " _n5YearPrimary$:" + _n5YearPrimary$ + " _n1YearSupp:" + _n1YearSupp
				+ " _n1YearSupp$:" + _n1YearSupp$ + " _n3YearSupp:" + _n3YearSupp + " _n3YearSupp$:" + _n3YearSupp$
				+ " _n5YearSupp:" + _n5YearSupp + " _n5YearSupp$:" + _n5YearSupp$ + " _trial:" + _trial + " _trial$:"
				+ _trial$ + " _trial3:" + _trial3 + " _trial3$:" + _trial3$ + " _trial5:" + _trial5 + " _trial5$:"
				+ _trial5$ + " _conv:" + _conv + " _conv$:" + _conv$ + " _conv3:" + _conv3 + " _conv3$:" + _conv3$
				+ " _conv5:" + _conv5 + " _convDep:" + _convDep + " _convDep$:" + _convDep$ + " _convDep3:" + _convDep3
				+ " _convDep3$:" + _convDep3$ + " _convDep5:" + _convDep5 + " _convDep5$:" + _convDep5$ + " _total:"
				+ _total + " _total$:" + _total$ + " _ttotal:" + _ttotal + " _ttotal$:" + _ttotal$ + " _ctotal:"
				+ _ctotal + " _ctotal$:" + _ctotal$ + " _cmpTkt:" + _cmpTkt + " _cmpTkt$:" + _cmpTkt$ + "\n";
	}
}
