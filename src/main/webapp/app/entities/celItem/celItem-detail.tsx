import React, { useEffect } from 'react';
import { Link, useParams } from 'react-router-dom';
import { Button, Row, Col } from 'reactstrap';
import { Translate } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { APP_DATE_FORMAT, APP_LOCAL_DATE_FORMAT } from 'app/config/constants';
import { useAppDispatch, useAppSelector } from 'app/config/store';

import { getEntity } from './celItem.reducer';

export const celItemDetail = () => {
  const dispatch = useAppDispatch();

  const { id } = useParams<'id'>();

  useEffect(() => {
    dispatch(getEntity(id));
  }, []);

  const celItemEntity = useAppSelector(state => state.celItem.entity);
  return (
    <Row>
      <Col md="8">
        <h2 data-cy="celItemDetailsHeading">
          <Translate contentKey="gitPodReactSpringJpaApp.celItem.detail.title">Item</Translate>
        </h2>
        <dl className="jh-entity-details">
          <dt>
            <span id="id">
              <Translate contentKey="global.field.id">ID</Translate>
            </span>
          </dt>
          <dd>{celItemEntity.id}</dd>
          <dt>
            <span id="celItemName">
              <Translate contentKey="gitPodReactSpringJpaApp.celItem.celItemName">CelItem Name</Translate>
            </span>
          </dt>
          <dd>{celItemEntity.celItemName}</dd>
          <dt>
            <span id="celItemDescription">
              <Translate contentKey="gitPodReactSpringJpaApp.celItem.celItemDescription">CelItem Descrição</Translate>
            </span>
          </dt>
          <dd>{celItemEntity.celItemDescription}</dd>
          <dt>
            <span id="celItemValor">
              <Translate contentKey="gitPodReactSpringJpaApp.celItem.celItemValor">CelItem Valor</Translate>
            </span>
          </dt>
          <dd>{celItemEntity.celItemValor}</dd>
        </dl>
        <Button tag={Link} to="/celItem" replace color="info" data-cy="entityDetailsBackButton">
          <FontAwesomeIcon icon="arrow-left" />{' '}
          <span className="d-none d-md-inline">
            <Translate contentKey="entity.action.back">Back</Translate>
          </span>
        </Button>
        &nbsp;
        <Button tag={Link} to={`/celItem/${celItemEntity.id}/edit`} replace color="primary">
          <FontAwesomeIcon icon="pencil-alt" />{' '}
          <span className="d-none d-md-inline">
            <Translate contentKey="entity.action.edit">Edit</Translate>
          </span>
        </Button>
      </Col>
    </Row>
  );
};

export default celItemDetail;
