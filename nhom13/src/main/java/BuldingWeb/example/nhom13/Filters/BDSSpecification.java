// File: BDSSpecification.java
package BuldingWeb.example.nhom13.Filters;

import BuldingWeb.example.nhom13.Entity.BatDongSan;
import BuldingWeb.example.nhom13.Enums.LoaiBDS;
import BuldingWeb.example.nhom13.Enums.TrangThaiBDS;
import BuldingWeb.example.nhom13.Model.Reponse.tkbdsReponse;
import org.springframework.data.jpa.domain.Specification;
import jakarta.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

public class BDSSpecification {

    public static Specification<BatDongSan> filter(tkbdsReponse dto) {
        return (root, query, criteriaBuilder) -> {

            List<Predicate> predicates = new ArrayList<>();

            if (dto.getSearchTerm() != null && !dto.getSearchTerm().isEmpty()) {
                String keyword = "%" + dto.getSearchTerm().toLowerCase() + "%";
                predicates.add(
                        criteriaBuilder.or(
                                criteriaBuilder.like(criteriaBuilder.lower(root.get("tieuDe")), keyword)
                        )
                );
            }


            if (dto.getTrangThai() != null && !dto.getTrangThai().isEmpty()) {
                try {
                    TrangThaiBDS trangThaiEnum = TrangThaiBDS.valueOf(dto.getTrangThai().toLowerCase());
                    predicates.add(criteriaBuilder.equal(root.get("trangThai"), trangThaiEnum));
                } catch (IllegalArgumentException e) {
                    System.err.println("Giá trị trangThai không hợp lệ: " + dto.getTrangThai());
                }
            }

            if (dto.getLoaiBds() != null && !dto.getLoaiBds().isEmpty()) {
                try {
                    LoaiBDS loaiBdsEnum = LoaiBDS.valueOf(dto.getLoaiBds().toLowerCase());
                    predicates.add(criteriaBuilder.equal(root.get("loaiBds"), loaiBdsEnum));
                } catch (IllegalArgumentException e) {
                    System.err.println("Giá trị loaiBds không hợp lệ: " + dto.getLoaiBds());
                }
            }

            if (dto.getViTri() != null && !dto.getViTri().isEmpty()) {
                String word = "%" + dto.getViTri().toLowerCase() + "%";
                predicates.add(
                        criteriaBuilder.or(
                                criteriaBuilder.like(criteriaBuilder.lower(root.get("viTri")), word),
                                criteriaBuilder.like(criteriaBuilder.lower(root.get("quanHuyen")), word),
                                criteriaBuilder.like(criteriaBuilder.lower(root.get("thanhPho")), word)
                        )
                );
            }


            if (dto.getMinPrice() != null) {
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("gia"), dto.getMinPrice()));
            }
            if (dto.getMaxPrice() != null) {
                predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("gia"), dto.getMaxPrice()));
            }


            if (dto.getMinArea() != null) {
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("dienTich"), dto.getMinArea()));
            }
            if (dto.getMaxArea() != null) {
                predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("dienTich"), dto.getMaxArea()));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}