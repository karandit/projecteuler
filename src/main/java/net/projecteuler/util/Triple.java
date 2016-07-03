package net.projecteuler.util;

public class Triple<T1, T2 , T3> {

	private final T1 mT1;
	private final T2 mT2;
	private final T3 mT3;
	
	public Triple(T1 t1, T2 t2, T3 t3) {
		mT1 = t1;
		mT2 = t2;
		mT3 = t3;
	}
	
	public T1 getA() { return mT1; } 
	public T2 getB() { return mT2; } 
	public T3 getC() { return mT3; }

	@Override
	public String toString() {
		return "(" + mT1 + ", " + mT2 + ", " + mT3 +")";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mT1 == null) ? 0 : mT1.hashCode());
		result = prime * result + ((mT2 == null) ? 0 : mT2.hashCode());
		result = prime * result + ((mT3 == null) ? 0 : mT3.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		@SuppressWarnings("rawtypes")
		Triple other = (Triple) obj;
		if (mT1 == null) {
			if (other.mT1 != null)
				return false;
		} else if (!mT1.equals(other.mT1))
			return false;
		if (mT2 == null) {
			if (other.mT2 != null)
				return false;
		} else if (!mT2.equals(other.mT2))
			return false;
		if (mT3 == null) {
			if (other.mT3 != null)
				return false;
		} else if (!mT3.equals(other.mT3))
			return false;
		return true;
	} 

}
