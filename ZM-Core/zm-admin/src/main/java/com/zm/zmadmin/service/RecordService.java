package com.zm.zmadmin.service;

import com.google.common.collect.Lists;
import com.zm.common.vo.PageResult;
import com.zm.zmadmin.entity.Record;
import com.zm.zmadmin.query.RecordQuery;
import com.zm.zmadmin.repository.RecordRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.Date;
import java.util.List;

/**
 * ==========================
 *
 * @author : yizuomin
 * @date : Created in 22:45 2020/4/26
 * ===========================
 */
@Service
public class RecordService {

    private RecordRepository recordRepository;

    @Autowired
    public RecordService(RecordRepository recordRepository) {
        this.recordRepository = recordRepository;
    }


    /**
     * @param record
     * @return 新增/修改
     */
    public Record save(Record record) {
        record.setCreateTime(new Date());
        return recordRepository.save(record);
    }

    /**
     * @param query
     * @return 列表查询
     */
    public PageResult list(RecordQuery query) {
        Specification<Record> specification = getSpecification(query);
        Sort sort = Sort.by("time");
        sort.descending();
        PageRequest pageRequest = PageRequest.of(query.getPage(), query.getLimit(), sort);
        Page<Record> all = recordRepository.findAll(specification, pageRequest);
        return PageResult.build(all.getTotalElements(), all.get());
    }


    private Specification<Record> getSpecification(RecordQuery query) {
        return new Specification<Record>() {
            @Override
            public Predicate toPredicate(Root<Record> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = Lists.newArrayList();
                if (null != query.getUserId()) {
                    predicates.add(criteriaBuilder.equal(root.get("userId"), query.getUserId()));
                }
                if (null != query.getStartTime() && null != query.getEndTime()) {
                    predicates.add(criteriaBuilder.between(root.get("time"), query.getStartTime(), query.getEndTime()));
                }
                if (null != query.getType()) {
                    predicates.add(criteriaBuilder.equal(root.get("type"), query.getType()));
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        };
    }
}
