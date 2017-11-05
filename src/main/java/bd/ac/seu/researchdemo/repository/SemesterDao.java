package bd.ac.seu.researchdemo.repository;

import bd.ac.seu.researchdemo.Models.Semester;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * @author rakib on 10/29/17
 * @project ResearchDemo
 */

@Repository
@Transactional
public interface SemesterDao extends CrudRepository<Semester, Integer > {
}
