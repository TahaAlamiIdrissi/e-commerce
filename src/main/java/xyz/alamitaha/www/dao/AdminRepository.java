package xyz.alamitaha.www.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import xyz.alamitaha.www.business.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {

}
