package service;

import org.springframework.stereotype.Service;

import com.aceleradev.api.exception.NotFoundException;

import domain.DemoResponseDTO;
import repository.DemoRepository;

@Service
public class DemoService {
	
	private DemoRepository demoRepository;
	
	public DemoService(DemoRepository demoRepository) {
		this.demoRepository = demoRepository;
	}

	public DemoResponseDTO findById(Long id) throws NotFoundException {
		return demoRepository.findById(id)
						.map(entity -> new DemoResponseDTO(entity.getId()))
						.orElseThrow(() -> new NotFoundException());
	}
	
}
