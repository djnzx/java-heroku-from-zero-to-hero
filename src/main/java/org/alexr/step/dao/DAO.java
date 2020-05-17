package org.alexr.step.dao;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public interface DAO<A> {
  List<A> getAll();
  List<A> getBy(Predicate<A> p);
  Optional<A> get(int id);
  void put(A a);
  void delete(int id);
}
