package kz.sw_sku_service.controller;

import jakarta.validation.Valid;
import kz.sw_sku_service.exception.CustomException;
import kz.sw_sku_service.model.dto.BrandDTO;
import kz.sw_sku_service.model.dto.SearchDTO;
import kz.sw_sku_service.model.dto.response.DeleteResponseDTO;
import kz.sw_sku_service.service.impl.BrandServiceImpl;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/b")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class BrandController {

    private final BrandServiceImpl brandServiceImpl;

    @PostMapping("/v1")
    public BrandDTO saveOne(@Valid @RequestBody BrandDTO dto) throws CustomException {
        log.info("Incoming request to save brand: {}", dto.toString());
        return brandServiceImpl.saveOne(dto);
    }

    @GetMapping("/v1/{id}")
    public BrandDTO getOne(@PathVariable Long id) throws CustomException {
        log.info("Incoming request to get brand with id: {}", id);
        return brandServiceImpl.getOne(id);
    }

    @PutMapping("/v1/{id}")
    public BrandDTO updateOne(@PathVariable Long id, @RequestBody BrandDTO dto) throws CustomException {
        log.info("Incoming request to update brand with id: {}.", id);
        return brandServiceImpl.updateOne(id, dto);
    }

    @DeleteMapping("/v1/{id}")
    public DeleteResponseDTO deleteOne(@PathVariable Long id) throws CustomException {
        log.info("Incoming request to delete brand with id: {}", id);
        return brandServiceImpl.deleteOne(id);
    }

    @PostMapping("/v1/search")
    public Page<BrandDTO> search(@RequestBody SearchDTO searchDTO, Pageable pageable) {
        log.info("Incoming request to search brand: {}", searchDTO);
        return brandServiceImpl.search(searchDTO, pageable);
    }
}
