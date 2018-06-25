package generic;

public class Command<T> implements ICommand<T>{
    public T entity;
    protected IRepository repository;
    protected Command(T entity,IRepository repository){
        this.entity = entity;
        this.repository = repository;
    }
}
