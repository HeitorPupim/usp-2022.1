public interface Chain {
   public abstract void setNext(Chain nextInChain);
   public abstract void process (Dimension request);
}
