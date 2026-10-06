package tarea1Interfaces;

public interface Estadisticas<T> {
	public abstract T mayor();
	public abstract T menor();
	public abstract double media();
	public abstract T[] mayoresQue(T obj);
	public abstract T[] menoresQue(T obj);
}
