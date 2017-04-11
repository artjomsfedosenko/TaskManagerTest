package lv.javaguru.java2.database;

import lv.javaguru.java2.domain.Comment;
import lv.javaguru.java2.domain.Task;

import java.util.List;
import java.util.Optional;

public interface CommentDAO {

    Optional<Comment> getById(Long id);

    List<Comment> getAll();
}
