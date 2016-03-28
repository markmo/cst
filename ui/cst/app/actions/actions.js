import { action, store } from 'reapp-kit';

const url = customerId => `http://localhost:8090/api/customers/${customerId}/events`;
const get = customerId => fetch(url(customerId)).then(validResponse);

function validResponse(response) {
  return response.json();
}

action('loadEvents', customerId => {
  get(customerId).then(resp => {
    store().set('events', resp);
  });
});