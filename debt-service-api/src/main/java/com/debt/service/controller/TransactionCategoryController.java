package com.debt.service.controller;

import com.debt.service.common.StatusCodeEnum;
import com.debt.service.common.TransactionCategoryEnum;
import com.debt.service.entity.TransactionCategoryEntity;
import com.debt.service.model.base.ResponseApi;
import com.debt.service.model.base.SimplePage;
import com.debt.service.model.request.TransactionCategoryRequest;
import com.debt.service.service.TransactionCategoryService;
import io.jsonwebtoken.lang.Strings;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author vi.trannguyenky
 * @since 6/27/2024 1:53 PM
 */
@RestController
@RequestMapping("/transaction-category")
@RequiredArgsConstructor
public class TransactionCategoryController {
    private final TransactionCategoryService service;

    @PostMapping("/create")
    public ResponseEntity<ResponseApi<TransactionCategoryEntity>> createTransactionCategory(@Valid @NonNull @RequestBody TransactionCategoryRequest payload) {
        return ResponseEntity.badRequest().body(ResponseApi.<TransactionCategoryEntity>builder()
                .status(StatusCodeEnum.SUCCESS.getStatusCode())
                .message(StatusCodeEnum.SUCCESS.getMessage())
                .data(service.createTransactionCategory(payload))
                .build());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ResponseApi<TransactionCategoryEntity>> getTransactionCategory(@NonNull @PathVariable Integer id) {
        return ResponseEntity.badRequest().body(ResponseApi.<TransactionCategoryEntity>builder()
                .status(StatusCodeEnum.SUCCESS.getStatusCode())
                .message(StatusCodeEnum.SUCCESS.getMessage())
                .data(service.getTransactionCategory(id))
                .build());
    }

    @GetMapping("/gets")
    public ResponseEntity<ResponseApi<SimplePage<TransactionCategoryEntity>>> getsTransactionCategory(@RequestParam("type") String type,
                                                                                                      @RequestParam("keyword") String keyword,
                                                                                                      @Min(0) @RequestParam(defaultValue = "0") int page,
                                                                                                      @Min(0) @Max(100) @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(ResponseApi.<SimplePage<TransactionCategoryEntity>>builder()
                .status(StatusCodeEnum.SUCCESS.getStatusCode())
                .message(StatusCodeEnum.SUCCESS.getMessage())
                .data(service.getsTransactionCategory(Strings.hasLength(type) ? TransactionCategoryEnum.valueOf(type) : null, keyword, page, size))
                .build());
    }
}
