package xyz.alamitaha.www.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import xyz.alamitaha.www.business.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
