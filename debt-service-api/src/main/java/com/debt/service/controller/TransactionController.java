package com.debt.service.controller;

import com.debt.service.common.StatusCodeEnum;
import com.debt.service.common.TransactionTypeEnum;
import com.debt.service.entity.TransactionEntity;
import com.debt.service.model.base.ResponseApi;
import com.debt.service.model.base.SimplePage;
import com.debt.service.model.request.TransactionRequest;
import com.debt.service.model.response.CalcTransactionResponse;
import com.debt.service.model.response.TransactionResponse;
import com.debt.service.service.TransactionService;
import com.debt.service.utils.date.DateUtil;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

/**
 * @author vi.trannguyenky
 * @since 6/27/2024 3:17 PM
 */
@RestController
@RequestMapping("/transaction")
@RequiredArgsConstructor
public class TransactionController {
    private final TransactionService transactionService;

    @PostMapping("/create")
    public ResponseEntity<ResponseApi<TransactionEntity>> createTransaction(@Valid @RequestBody TransactionRequest payload) {
        return ResponseEntity.ok(ResponseApi.<TransactionEntity>builder()
                .status(StatusCodeEnum.SUCCESS.getStatusCode())
                .message(StatusCodeEnum.SUCCESS.getMessage())
                .data(transactionService.create(payload))
                .build());
    }

    @GetMapping("/total-in-range")
    public ResponseEntity<ResponseApi<CalcTransactionResponse>> totalInRange(@RequestParam("startDate") String startDate,
                                                                             @RequestParam("endDate") String endDate,
                                                                             @RequestParam("type") TransactionTypeEnum type,
                                                                             @RequestParam("category") String category) throws ParseException {

        return ResponseEntity.ok(ResponseApi.<CalcTransactionResponse>builder()
                .status(StatusCodeEnum.SUCCESS.getStatusCode())
                .message(StatusCodeEnum.SUCCESS.getMessage())
                .data(transactionService
                        .accurateTransactionInRange(DateUtil.convertStringToDate(startDate), DateUtil.convertStringToDate(endDate), type, category))
                .build());
    }

    @GetMapping("/gets")
    public ResponseEntity<ResponseApi<SimplePage<TransactionResponse>>> gets(@RequestParam("startDate") String startDate,
                                                                             @RequestParam("endDate") String endDate,
                                                                             @RequestParam("type") TransactionTypeEnum type,
                                                                             @RequestParam("category") String category,
                                                                             @Min(0) @RequestParam(value = "size", defaultValue = "10") int size,
                                                                             @Min(0) @RequestParam(value = "page", defaultValue = "0") int page) throws ParseException {

        return ResponseEntity.ok(ResponseApi.<SimplePage<TransactionResponse>>builder()
                .status(StatusCodeEnum.SUCCESS.getStatusCode())
                .message(StatusCodeEnum.SUCCESS.getMessage())
                .data(transactionService
                        .gets(DateUtil.convertStringToDate(startDate), DateUtil.convertStringToDate(endDate), type, category, size, page))
                .build());
    }
}
