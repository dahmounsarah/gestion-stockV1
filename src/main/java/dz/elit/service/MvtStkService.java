package dz.elit.service;
import dz.elit.dto.MvtStkDto;
import java.util.List;

public interface MvtStkService {
    MvtStkDto save(MvtStkDto mvtStkDto);

    MvtStkDto findById(Integer id);

    MvtStkDto findByCodeArticle(String code);

    List<MvtStkDto> findAll();

    void delete(Integer mvtStkDtoId);
}
