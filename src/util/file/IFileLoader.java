package util.file;

import java.util.List;

public interface IFileLoader<T> {

    List <T> load();
}