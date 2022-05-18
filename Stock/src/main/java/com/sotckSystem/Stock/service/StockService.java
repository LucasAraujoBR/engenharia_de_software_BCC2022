package com.sotckSystem.Stock.service;

import com.opencsv.CSVWriter;
import com.sotckSystem.Stock.mapper.StockMapper;
import com.sotckSystem.Stock.model.DTO.StockDTO;
import com.sotckSystem.Stock.model.Stock;
import com.sotckSystem.Stock.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.DecimalMin;
import java.io.IOException;
import java.io.Writer;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class StockService {
    @Autowired
    private StockRepository repository;

    @Autowired
    private StockMapper mapper;

    @Transactional(readOnly = true)
    public List<StockDTO> findAll() {
        return mapper.toDtoAll(repository.findAll()) ;
    }

    @Transactional()
    public void save(StockDTO dto) {
        repository.save(mapper.toEntity(dto));
    }

    @Transactional(readOnly = true)
    public List<StockDTO> findByToday() {
        return repository
                .findByDate(LocalDate.now())
                .map(mapper::toDtoAll)
                .orElseThrow(RuntimeException::new);
    }
    @Transactional(readOnly = true)
    public List<StockDTO> findByName(String name) {
        return repository
                .findByName(name)
                .map(mapper::toDtoAll)
                .orElseThrow(RuntimeException::new);
    }
    @Transactional()
    public StockDTO findById(Long id) {
        return mapper.toDto(repository.findById(id).get());
    }
    @Transactional()
    public void update(StockDTO stockUp) {
        Stock stock = mapper.toEntity(stockUp);
        stock.setId(stockUp.getId());
        repository.save(stock);
    }
    @Transactional()
    public void delete(Long id) {
        repository.deleteById(id);
    }


    public List<StockDTO> findByDono(String cpf) {
        List<Stock> stocks = repository.findByDono(cpf);
        return mapper.toDtoAll(stocks);

    }
    public double somaInvestido(String cpf){
        List<Stock> stocks = repository.findByDono(cpf);
        double soma = 0.0;
        for (Stock stock: stocks){
            soma += stock.getPrice();
        }
        return soma;
    }

    public void gerarCsv(String cpf) {
        List<Stock> stocks = repository.findByDono(cpf);
        List<String[]> linhas = new ArrayList<>();
        String[] cabecalho = {"Taxa", "Investido", "Data do Investimento", "Nome"};
        for(Stock stock:stocks){
            linhas.add(new String[]{stock.getVariation().toString(),stock.getPrice().toString(), stock.getDate().toString(), stock.getName() });
        }
        Writer writer = null;
        try {
            writer = Files.newBufferedWriter(Paths.get("investimentos.csv"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        CSVWriter csvWriter = new CSVWriter(writer);

        csvWriter.writeNext(cabecalho);
        csvWriter.writeAll(linhas);

        try {
            csvWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
